import javaposse.jobdsl.dsl.DslFactory


//add your project to the array
def projects =
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
projects.each {
    def project = it

    factory.multibranchPipelineJob("${project['name']}") {

        branchSources {
            github {
//                scanCredentialsId('f0bdd864-99d4-4450-a12c-a00b94d96aa0')
                repoOwner(project['githubOwner'])
                repository(project['githubRepo'])
                includes('*')
            }
        }
    }

}

factory.listView("Java Microservices") {
    description("All Java Microservices")
    jobs {
        projects.each {
            name(it['name'])
        }
    }
}


