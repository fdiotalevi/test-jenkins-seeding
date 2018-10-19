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
    columns{
        status()
        weather()
        name()
        lastSuccess()
        lastFailure()
        lastDuration()
        buildButton()
    }
}


