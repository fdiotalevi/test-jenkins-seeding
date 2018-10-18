import javaposse.jobdsl.dsl.DslFactory

DslFactory factory = this


def projects = readFile("src/main/groovy/projects.groovy")
evaluate(projects)

jobs.each {
    def name = it["name"]
    def repo = it["repository"]


    factory.pipelineJob("${name}") {
        definition {

            cpsScm {
                scm {
                    git {
                        remote {
                            url(repo)
                        }
                        branches("master")
                        scriptPath("Jenkinsfile")
                    }
                }
            }
        }
    }
}


