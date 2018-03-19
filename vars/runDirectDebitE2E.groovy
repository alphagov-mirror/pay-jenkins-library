#!/usr/bin/env groovy

def call(
        String app,
        String tag = null,
        String jobName = 'run-end-to-end-direct-debit-tests') {

    if (tag == null) {
        commit = env.GIT_COMMIT ?: gitCommit()
        tag = "${commit}-${env.BUILD_NUMBER}"
    }

    build job: jobName,
            parameters: [
                    string(name: 'MODULE_NAME', value: app),
                    string(name: 'MODULE_TAG', value: tag)
            ]
}
