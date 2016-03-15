package me.eroshenkoam.examples;

import com.google.gson.Gson;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static me.eroshenkoam.examples.ClientFactory.createClient;
import static me.eroshenkoam.examples.ClientFactory.createGson;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author Artem Eroshenko <erosenkoam@me.com>
 */
public class GitHubClientTest {

    @SuppressWarnings("unchecked")
    private final String username = "eroshenkoam";

    private final String endpoint = "https://api.github.com";

    private GitHubClient gitHubClient = createClient(GitHubClient.class, endpoint);

    @Test
    public void fullNameOfEachRepositoryMustStartWithUsername() throws Exception {

        List<Repository> repositories = gitHubClient.listRepos(username).execute().body();
        assertThat(repositories, everyItem(hasProperty("fullName", startsWith(username))));

    }

    @Test
    @Ignore("It's not test actually")
    public void printAllUserRepositories() throws Exception {

        Gson gson = createGson();

        List<Repository> repositories = gitHubClient.listRepos(username).execute().body();
        repositories.forEach(repository -> System.out.println(gson.toJson(repository)));

    }


}
