# 📘 StudyTrack - Projeto Base para Disciplina de DevOps

Este projeto foi desenvolvido como parte da disciplina de **DevOps** do curso **Bacharelado em Sistemas de Informação**, com o objetivo de aplicar conceitos de **integração contínua, containerização, 12-Factor App** e boas práticas de desenvolvimento moderno.

---

## 👩‍💻 Autora

Nome: Esther Nascimento Soares de Freitas
Curso: Bacharelado em Sistemas de Informação – IFAL
Disciplina: DevOps
Período: 2025.2
Professor: [Ivo Calado](https://github.com/ivocalado)

## 🚀 Descrição do Projeto

**StudyTrack** é uma aplicação Web que auxilia estudantes no planejamento e acompanhamento de estudos.
Ela permite cadastrar disciplinas, criar planos de estudo e registrar tarefas, monitorando o progresso de cada curso.

O projeto servirá como base para as próximas etapas da disciplina, nas quais serão aplicados os conceitos de **automação, pipelines, deploy contínuo e observabilidade**.

---

## 🧩 Tecnologias Utilizadas


| Categoria         | Tecnologia                          |
| ----------------- | ----------------------------------- |
| Linguagem         | Java 17+                            |
| Framework         | Spring Boot                         |
| Persistência     | Spring Data JPA + Hibernate         |
| Banco de Dados    | PostgreSQL (não em memória)       |
| Logs              | Logback (stdout)                    |
| Build             | Gradle                              |
| Containerização | Docker + Docker Compose             |
| Versionamento     | Git + GitHub (repositório privado) |

## ⚙️ Como usar

- Para rodar:

```
minikube start
kubectl create namespace argocd
kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml

# aguardar um minuto pra rodar o próximo
kubectl port-forward svc/argocd-server -n argocd 8080:443
```

- Acesse o Argo em [https://localhost:8080](https://localhost:8080/)
- Consulte a senha em:
  ```
  kubectl -n argocd get secret argocd-initial-admin-secret -o jsonpath="{.data.password}" | base64 -d && echo`
  ```

* Vá em **Settings > Repositories > Connect Repo using HTTPS**
* Adicione:
  * URL: `https://github.com/estherdefreitas/studytrack-devops`

- Depois rodar:

```
kubectl apply -f https://raw.githubusercontent.com/cloudnative-pg/cloudnative-pg/release-1.21/releases/cnpg-1.21.0.yaml
# kubectl apply -f db-operator/cnpg-1.21.0.yaml


# aguardar um minuto pra rodar o próximo
kubectl apply -f argocd/projects/studytrack-project.yaml -n argocd
kubectl apply -f argocd/apps/studytrack-dev.yaml -n argocd
kubectl apply -f argocd/apps/studytrack-prod.yaml -n argocd
kubectl apply -f db-operator/postgres-cluster-dev.yaml
kubectl apply -f db-operator/postgres-cluster-prod.yaml
```

- Para acessar a aplicação:

  ```
  kubectl port-forward svc/studytrack-app-service -n studytrack-dev 8081:8080
  ```
- Acesse em [https://localhost:8080](https://localhost:8080/)

## 🧾 Licença

Este projeto é de uso educacional e foi desenvolvido para fins acadêmicos na disciplina de DevOps do curso Bacharelado em Sistemas de Informação.