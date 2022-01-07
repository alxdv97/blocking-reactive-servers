<h1>Project for simple benchmarking blocking REST and reactive REST web servers</h1>

<h2>Components:</h2>
<ol>
<li><b>blocking-server</b> - plain server with blocking API and jdbc drivers</li>
<li><b>reactive-server</b> - full reactive server with Spring WebFlux API and r2dbc drivers</li>
<li><b>testing-server</b> - testing server which simultaneously send up to 1000 (WebFlux webClient limitation), requesting from REST endpoint</li>
</ol>

<h2>Running:</h2>
<p>Run docker-compose up --build from base directory.</p>

<h2>Endpoints:</h2>
<ol>
<li><b>blocking-server</b> - http://localhost:8080/swagger-ui/</li>
<li><b>reactive-server</b> - http://localhost:8081/swagger-ui/</li>
<li><b>testing-server</b> - http://localhost:8888/swagger-ui/</li>
</ol>
