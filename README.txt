Instruções para teste da aplicação back end

Rode o projeto no CMD com o comando: mvn spring-boot:run

Na pasta resource/h2 contem dois arquivos de script .sql
um deles é para a geração da tables e outro para inserir dados na tabela.

Os testes foram realizados com a aplicação rodando e utilizando a ferramenta
Postman 
os dois contextos utilizados são:
/jobs
/tasks
cada um possui sua propria controller e os metodos com as funcionalidades.