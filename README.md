# Avaliacao-Ekan
Avaliação - Desenvolvedor Backend Java / Utilizando Spring Boot e H2

# Como a Aplicação foi desenvolvida:

Para iniciar, foi acessado o site: https://start.spring.io, aonde foi adicionada a ferramenta Maven, que serve para automatizar e gerenciar as dependências adicionadas, que foram: 
- Spring Boot DevTools(Fornece reinicializações rápidas de aplicativos, LiveReload e configurações para uma experiência de desenvolvimento aprimorada);
- Spring Web(Crie aplicativos da web, incluindo RESTful, utilizando o Apache Tomcat como padrão container incorporado);
- Spring Data JPA¹(Persiste os dados em armazenamentos SQL com Java Persistence API (JPA) usando Spring Data e Hibernate²);
- Validation(Validação de Bean com validador Hibernate);
- H2 Database(Fornece um banco de dados rápido na memória que suporta API JDBC³, com um espaço pequeno).

JPA¹: É uma interface que define mapeamentos das classes e algumas configurações.
Hibernate²: É uma ferramenta de mapeamento que diferente da JPA, ela é uma classe que implementa a JPA.
JDBC³: Realiza a manipulação dos dados de acordo com as suas características. JPA e JDBC ambas são tecnologias para acessar o banco de dados em JAVA. 

Logo após fazer toda a importação do projeto, iniciei a lógica pelo "Beneficiario" em sequência "BeneficiarioRepository", "BeneficiarioController", "Documento", "DocumentoRepository", "DocumentoController". Ao finalizar toda a lógica, foram realizados os seguintes testes: 

- Cadastrar um beneficiário junto com seus documentos;
- Listar todos os beneficiários cadastrados;
- Listar todos os documentos de um beneficiário a partir de seu id;
- Atualizar os dados cadastrais de um beneficiário;
- Remover um beneficiário.

Para realizar os testes, utilizei a ferramenta INSOMNIA, aonde foram inseridos os dados solicitados no "Beneficiario" e "Documento".

# Instruções de como executar a aplicação: 

Antes de começar, você terá que ter instalado na sua máquina as seguintes ferramentas:

1º Uma IDE, como por exemplo, Eclipse, IntelliJ IDEA, NetBeans, ou, assim como eu, SpringTools 4 (entre outras, da sua preferência);
2º Baixe e instale o GitBash para realizar a clonagem do repositório na sua máquina;
3º Insomnia para realizar os envios de requisições;
4º Configurar o Insomnia, definir os Get, Post, Put e Delete, para, respectivamente, consultar todos os beneficiarios e/ou consultar beneficiario por id, cadastrar um novo beneficiario, atualizar os dados e deletar um beneficiário. (anexo¹)

![anexo¹](https://i.imgur.com/Q44E5lU.png) 
(anexo¹)

Tendo todas as ferramentas instaladas e configuradas, vamos partir para o código!

Entre no repositório: https://github.com/ElsonSilv4/Avaliacao-Ekan, clique em "<> Code" e copie o link que aparece logo abaixo de HTTPS;
Vá para uma pasta da sua preferência e clique num espaço vazio com o botão direito, em seguida, "Git Bash Here";
Digite "git clone (link que voce copiou)" sem os parênteses "()";
Logo após isso, você verá que foi criado uma pasta;
Abra a sua IDE, clique em "new" ou "novo", "importar" ou "import", selecione o diretório, clique na pasta que foi clonada e espere o sistema carregar;
Assim que o sistema carregar todos os arquivos, clique em "BeneficiarioApplication.java" e clique em "Run" ou "Iniciar";
Logo após carregar todas as linhas do console, abra o Insomnia;
Criando todos os "Requests", coloque no espaço solicitado a url padrão que é "localhost:8080/avaliacaoEkan/documentos" e cadastre um tipo de documento e descrição;(anexo²)
![anexo²](https://i.imgur.com/nHVcQ7a.png)

Em seguida, crie um Beneficiário e preencha todas as informações solicitadas;
(anexo³)
![anexo³](https://i.imgur.com/r3cCe4l.png)

E por fim, verifique todas as informações mostrando o "Beneficiario" junto ao "Documento" do mesmo.
(anexo⁴)
![anexo⁴](https://i.imgur.com/Fn3juyJ.png)












