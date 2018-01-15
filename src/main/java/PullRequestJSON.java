/**
 * Created by Benjamin DANGLOT
 * benjamin.danglot@inria.fr
 * on 08/01/18
 */
public class PullRequestJSON {

    public final int id;
    public final String baseSha;
    public final String url;
    public final String headSha;

    public PullRequestJSON(int id, String baseSha, String url, String headSha) {
        this.id = id;
        this.baseSha = baseSha;
        this.url = url;
        this.headSha = headSha;
    }
}
