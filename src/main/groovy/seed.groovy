import javaposse.jobdsl.dsl.DslFactory

DslFactory factory = this


evaluate(new File("${WORKSPACE}/src/main/groovy/projects.groovy"))


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


