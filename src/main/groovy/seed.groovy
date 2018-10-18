import javaposse.jobdsl.dsl.DslFactory

DslFactory factory = this

def jobs =
        [[
                 name: "Cryptoeval",
                 repository: "https://github.com/fdiotalevi/cryptoeval.git"
         ]]






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


