![build](https://github.com/alxdv97/blocking-reactive-servers/actions/workflows/maven.yaml/badge.svg)
[![codecov](https://codecov.io/gh/alxdv97/blocking-reactive-servers/branch/master/graph/badge.svg?token=XSocJKIRH4)](https://codecov.io/gh/alxdv97/blocking-reactive-servers)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=alxdv97_blocking-reactive-servers&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=alxdv97_blocking-reactive-servers)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=alxdv97_blocking-reactive-servers&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=alxdv97_blocking-reactive-servers)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=alxdv97_blocking-reactive-servers&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=alxdv97_blocking-reactive-servers)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=alxdv97_blocking-reactive-servers&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=alxdv97_blocking-reactive-servers)


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

<h2>Try it out!</h2>
<ol>
<li>Go to http://localhost:8888/swagger-ui/</li>
<li>Select testServer endpoint</li>
<li>Set the params: <b>serverType</b> may be <i>BLOCKING</i> or <i>REACTIVE</i>, <b>requestAmount</b> - natural number</li>
</ol>
