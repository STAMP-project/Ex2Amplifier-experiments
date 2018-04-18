package eu.stamp.project.git;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PullRequestJSON that = (PullRequestJSON) o;

        if (id != that.id) return false;
        if (baseUrl != null ? !baseUrl.equals(that.baseUrl) : that.baseUrl != null) return false;
        if (baseRef != null ? !baseRef.equals(that.baseRef) : that.baseRef != null) return false;
        if (baseSha != null ? !baseSha.equals(that.baseSha) : that.baseSha != null) return false;
        if (headUrl != null ? !headUrl.equals(that.headUrl) : that.headUrl != null) return false;
        if (headRef != null ? !headRef.equals(that.headRef) : that.headRef != null) return false;
        if (headSha != null ? !headSha.equals(that.headSha) : that.headSha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (baseUrl != null ? baseUrl.hashCode() : 0);
        result = 31 * result + (baseRef != null ? baseRef.hashCode() : 0);
        result = 31 * result + (baseSha != null ? baseSha.hashCode() : 0);
        result = 31 * result + (headUrl != null ? headUrl.hashCode() : 0);
        result = 31 * result + (headRef != null ? headRef.hashCode() : 0);
        result = 31 * result + (headSha != null ? headSha.hashCode() : 0);
        return result;
    }
}
