import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ResetCommand;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Cloner {

    /**
     *
     *  This method will clone a repository.
     *  Then make a copy it.
     *  Then, will reset hard to sha1 one version, and sha2 the second version
     *  The first version (sha1) will be in outputPath
     *  The second version (sha2) will be in outputPath + "_modified"
     * @param uriBase the url of the base github repository to be cloned
     * @param uriPR the url of the github repository to be cloned contained the pull request
     * @param outputPath the path where to clone it
     * @param sha1 the sha of the commit of the first version
     * @param sha2 the sha of the commit of the second version
     */
    public static void cloneBothVersionOf(String uriBase,
                                          String uriPR,
                                          String outputPath,
                                          String sha1,
                                          String sha2) {
        try {
            clone(uriBase, outputPath);
            clone(uriPR, outputPath + SUFFIX_VERSION_2);
            resetHard(outputPath, sha1);
            resetHard(outputPath + SUFFIX_VERSION_2, sha2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void copy(String outputPath) throws URISyntaxException, IOException {
        FileUtils.copyDirectory(new File(outputPath),
                new File(outputPath + SUFFIX_VERSION_2)
        );
    }

    private static void resetHard(String outputPath, String sha) throws IOException, GitAPIException {
        Git.open(new File(outputPath))
                .reset()
                .setMode(ResetCommand.ResetType.HARD)
                .setRef(sha)
                .call();
    }

    private static void clone(String uri, String outputPath) throws GitAPIException {
            Git.cloneRepository()
                    .setURI(uri)
                    .setDirectory(new File(outputPath))
                    .call();
    }

    private static final String SUFFIX_VERSION_2 = "_modified";

}
