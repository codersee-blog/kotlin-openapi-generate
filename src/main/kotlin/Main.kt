import org.openapitools.client.apis.PostsApi

fun main() {
  val api = PostsApi(basePath = "https://jsonplaceholder.typicode.com")

  api.getPosts()
    .forEach(::println)
}