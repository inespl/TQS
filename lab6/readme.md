# Task 1: Analyze an existing project 

```
sudo docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest
```

token: c49c8b14ceb292de1e4e8f986ff7e9abf3f0ac71

Analize
Na pasta do projeto:
```
mvn compile
mvn sonar:sonar \
  -Dsonar.projectKey=euromilhoes_tqs_lab1 \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=c49c8b14ceb292de1e4e8f986ff7e9abf3f0ac71
```

Issue		|	Problem Description		|		How to solve				|
--------------	|------------------------------------	| --------------------------------------------------	|
Bug		| "Random" objects should be reused	| Create a single Random, then store, and reuse it.	|
--------------	|------------------------------------	| --------------------------------------------------	|
Vulnerability	|		 -			|			- 				|
--------------	|------------------------------------	| --------------------------------------------------	|
		| Refactor the code in order to not	| the stop condition is set to a local variable just	|
		| assign to this loop counter from 	| before the loop begins				|
		| within the loop body.		| Ex: for (int i = 0; i < 10; i++) {...}		|
Code smells	|------------------------------------	| --------------------------------------------------	|
(major)	|Unused assignments should be removed	| All calculated values should be used.		|
		|------------------------------------	| --------------------------------------------------	|
		| Standard outputs should not be used	| Not this: System.out.println("My Message");  	|
		| directly to log anything		| But this: logger.log("My Message");			|

		
# Task 2: Resolve technical debt

Debt: 2h 27min
 -> estimativa do tempo que demoraria a resolver os bugs/vulnerabilities/code smells existentes

Coverage: começou a 0% com 135 uncovered lines e acabou com 0% também e 136 uncovered lines
Diz Failed devido a uma condição

Pq é q a coverage é 0??? - ver depois


# Task 3: Define and apply quality gates

Bugs	| Vulnerabilities	| Hotspots Reviewed	| Code Smells	| Coverage	| Duplications	| Lines
6 - E	| 0 - A		| 0.0% - E		| 268 - A	| 0.0%		| 6.1% 	| 2.4k

Passou à 1a, criei um quality gate onde falhava se os code smells fossem mais q 200s e depois de analisar outra vez já falhou


# Task 4: Static code analysis at the IDE



