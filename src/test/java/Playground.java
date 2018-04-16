import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.inria.diversify.utils.DSpotUtils;
import eu.stamp.project.git.Cloner;
import eu.stamp.project.git.ProjectJSON;
import eu.stamp.project.git.PullRequestJSON;
import org.junit.Ignore;
import org.junit.Test;
import org.kohsuke.github.GHIssueState;
import org.kohsuke.github.GHPullRequest;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Playground {

    private static final Logger LOGGER = LoggerFactory.getLogger(Playground.class);

    @Ignore
    @Test
    public void getByID() throws Exception {

        final String nameOfRepository = "square/javapoet";
//        final String nameOfRepository = "xwiki/xwiki-rendering";
//        final String nameOfRepository = "prestodb/pcccresto";
//        final String nameOfRepository = "protostuff/protostuff";
//        final String nameOfRepository = "mybatis/mybatis-3";
        final int idOfPullRequest = 550;

        final GitHub gitHub = GitHub.connectAnonymously();
        final GHRepository repository = gitHub.getRepository(nameOfRepository);
        final GHPullRequest ghPullRequest = repository.getPullRequest(idOfPullRequest);
        final String fileName = "dataset/january-2018" + "/" + repository.getName() + ".json";
        final PullRequestJSON pullRequestJSON = new PullRequestJSON(ghPullRequest.getNumber(),
                ghPullRequest.getBase().getRepository().getGitTransportUrl(),
                ghPullRequest.getBase().getRef(),
                ghPullRequest.getBase().getCommit().getSHA1(),
                ghPullRequest.getHead().getRepository().getGitTransportUrl(),
                ghPullRequest.getHead().getRef(),
                ghPullRequest.getHead().getCommit().getSHA1()
        );
        final ProjectJSON projectJSON;
        if (new File(fileName).exists()){
            Gson gson = new Gson();
            projectJSON = gson.fromJson(new FileReader(fileName), ProjectJSON.class);
            projectJSON.pullRequests.add(pullRequestJSON);
        } else{
            projectJSON = new ProjectJSON(repository.getName(),
                    repository.getGitTransportUrl(),
                    Collections.singletonList(pullRequestJSON));
        }
        try (Writer writer = new FileWriter(fileName)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(projectJSON, writer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Ignore
    @Test
    public void get() throws Exception {
        final GitHub gitHub = GitHub.connectAnonymously();
        final GHRepository repository = gitHub.getRepository("square/javapoet");
        final List<GHPullRequest> pullRequests = repository.getPullRequests(GHIssueState.CLOSED);
        LOGGER.info("{} pull requests", pullRequests.size());
        final List<GHPullRequest> refactorPR = pullRequests.stream()
                .filter(ghPullRequest1 ->
                        ghPullRequest1.getTitle().toLowerCase().contains("refactor")
                ).collect(Collectors.toList());
        LOGGER.info("{} pull request are about refactoring", refactorPR.size());
        final ProjectJSON projectJSON = new ProjectJSON(repository.getName(),
                repository.getGitTransportUrl(),
                refactorPR.stream()
                        .map(ghPullRequest -> {
                                    DSpotUtils.printProgress(refactorPR.indexOf(ghPullRequest), refactorPR.size());
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
                                }
                        ).collect(Collectors.toList()));
        try (Writer writer = new FileWriter("dataset/january-2018" + "/" + projectJSON.name + ".json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(projectJSON, writer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Ignore
    @Test
    public void cloneAllPullRequest() throws Exception {
        Gson gson = new Gson();
        final ProjectJSON projectJSON =
                gson.fromJson(new FileReader("dspot_pull_request_list.json"), ProjectJSON.class);
        projectJSON.pullRequests.forEach(pr ->
                Cloner.cloneBothVersionOf(pr, projectJSON.name)
        );
    }
}
