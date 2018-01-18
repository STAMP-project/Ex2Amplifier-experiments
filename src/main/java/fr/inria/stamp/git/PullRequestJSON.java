package fr.inria.stamp.git;

/**
 * Created by Benjamin DANGLOT
 * benjamin.danglot@inria.fr
 * on 08/01/18
 */
public class PullRequestJSON {

    public final int id;
    public final String baseUrl;
    public final String baseRef;
    public final String baseSha;
    public final String headUrl;
    public final String headRef;
    public final String headSha;

    public PullRequestJSON(int id,
                           String baseUrl, String baseRef, String baseSha,
                           String headUrl, String headRef, String headSha) {
        this.id = id;
        this.baseUrl = baseUrl;
        this.baseRef = baseRef;
        this.baseSha = baseSha;
        this.headUrl = headUrl;
        this.headRef = headRef;
        this.headSha = headSha;
    }
}
