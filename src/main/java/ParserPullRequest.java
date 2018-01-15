import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.kohsuke.github.GHIssueState;
import org.kohsuke.github.GHPullRequest;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ParserPullRequest {

    private static final String OUTPUT_NAME = "_pull_request_list.json";

    public static void buildPullRequestList(String name) {
        final ProjectJSON projectJSON = buildProjectJSON(name);
        try (Writer writer = new FileWriter(projectJSON.name + OUTPUT_NAME)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(projectJSON, writer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private final static Function<GHPullRequest, PullRequestJSON> GH_PULL_REQUEST_PULL_REQUEST_JSON_FUNCTION = ghPullRequest -> {
        try {
            return new PullRequestJSON(ghPullRequest.getNumber(),
                    ghPullRequest.getBase().getCommit().getSHA1(),
                    ghPullRequest.getHead().getRepository().getGitTransportUrl(),
                    ghPullRequest.getHead().getCommit().getSHA1()
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };

    private static ProjectJSON buildProjectJSON(String name) {
        try {
            final GitHub gitHub = GitHub.connectAnonymously();
            final GHRepository repository = gitHub.getRepository(name);
            final List<GHPullRequest> openedPullRequests = repository.getPullRequests(GHIssueState.OPEN);
            return new ProjectJSON(repository.getName(),
                    repository.getGitTransportUrl(),
                    openedPullRequests.stream()
                            .map(GH_PULL_REQUEST_PULL_REQUEST_JSON_FUNCTION)
                            .collect(Collectors.toList())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
