package eu.stamp_project.git;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;
import org.kohsuke.github.GHIssueState;
import org.kohsuke.github.GHPullRequest;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ParserPullRequest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParserPullRequest.class);

    private static final String OUTPUT_NAME = "_pull_request_list.json";

    public static void buildPullRequestList(String outputDirectory, String name) {
        final ProjectJSON projectJSON = buildProjectJSON(name);
        final File directory = new File(outputDirectory);
        if (!directory.exists()) {
            try {
                FileUtils.forceMkdir(directory);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (Writer writer = new FileWriter(outputDirectory + "/" + projectJSON.name + OUTPUT_NAME)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(projectJSON, writer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private final static Function<GHPullRequest, PullRequestJSON> GH_PULL_REQUEST_PULL_REQUEST_JSON_FUNCTION = ghPullRequest -> {
        try {
            return new PullRequestJSON(ghPullRequest.getNumber(),
                    ghPullRequest.getBase().getRepository().getGitTransportUrl(),
                    ghPullRequest.getBase().getRef(),
                    ghPullRequest.getBase().getCommit().getSHA1(),
                    ghPullRequest.getHead().getRepository().getGitTransportUrl(),
                    ghPullRequest.getHead().getRef(),
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
            LOGGER.info("{} opened pull request on {}", openedPullRequests.size(), name);
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
