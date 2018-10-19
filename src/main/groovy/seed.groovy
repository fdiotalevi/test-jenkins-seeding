import javaposse.jobdsl.dsl.DslFactory


//add your project to the array
def jobs =
[
        [
         name: "demo-delete-me-1",
         repository: "https://github.com/fdiotalevi/cryptoeval.git"
        ]
]




// don't modify down here

DslFactory factory = this
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


