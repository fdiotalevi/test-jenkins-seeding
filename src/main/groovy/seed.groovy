import javaposse.jobdsl.dsl.DslFactory


//add your project to the array
def jobs =
[
        [
            name: "demo-delete-me-1",
            githubOwner: 'fdiotalevi',
            githubRepo: "cryptoeval"
        ],
        [
            name: "demo-delete-me-2",
            githubOwner: "fdiotalevi",
            githubRepo: "ta4j"
        ]
]



// don't modify down here

DslFactory factory = this
jobs.each {
    def job = it

    factory.multibranchPipelineJob("${job['name']}") {

        branchSources {
            github {
//                scanCredentialsId('github-ci')
                repoOwner(job['githubOwner'])
                repository(job['githubRepo'])
                includes('*')
            }
        }

    }


//    factory.pipelineJob("${name}") {
//        definition {
//
//            cpsScm {
//                scm {
//                    git {
//                        remote {
//                            url(repo)
//                        }
//                        branches("master")
//                        scriptPath("Jenkinsfile")
//                    }
//                }
//            }
//        }
//    }
}


