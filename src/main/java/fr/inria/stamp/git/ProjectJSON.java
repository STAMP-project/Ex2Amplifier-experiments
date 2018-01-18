package fr.inria.stamp.git;

import java.util.List;

/**
 * Created by Benjamin DANGLOT
 * benjamin.danglot@inria.fr
 * on 08/01/18
 */
public class ProjectJSON {

    public final String name;
    public final String url;
    public final List<PullRequestJSON> pullRequests;

    public ProjectJSON(String name, String url, List<PullRequestJSON> pullRequests) {
        this.name = name;
        this.url = url;
        this.pullRequests = pullRequests;
    }
}
