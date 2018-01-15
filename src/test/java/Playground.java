import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.kohsuke.github.GHIssueState;
import org.kohsuke.github.GHPullRequest;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class Playground {

    @Test
    public void get() throws Exception {
        try (BufferedReader buffer = new BufferedReader(new FileReader("dataset/projects"))) {
            buffer.lines().forEach(ParserPullRequest::buildPullRequestList);
        }
    }

    @Test
    public void cloneAllPullRequest() throws Exception {
        Gson gson = new Gson();
        final ProjectJSON projectJSON =
                gson.fromJson(new FileReader("javapoet_pull_request_list.json"), ProjectJSON.class);
        projectJSON.pullRequests.forEach(pr ->
                Cloner.cloneBothVersionOf(projectJSON.url, "out_" + pr.id,
                        pr.baseSha, pr.headSha)
        );
    }

    @Test
    public void testParserPullRequest() throws Exception {
        Cloner.cloneBothVersionOf("https://github.com/STAMP-project/dspot.git",
                "out", "f7305a3203745f0e79e126c37843d1eaa73c9041", "d8e8a01be9966975aa31cc5a360e0dbc9f72b4cc"
                );
    }
}
