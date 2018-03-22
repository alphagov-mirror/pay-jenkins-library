#!/usr/bin/env groovy

def call(
        String app,
        String tag = null,
        String pay_scripts_branch = 'master') {

    if (tag == null) {
        commit = env.GIT_COMMIT ?: gitCommit()
        tag = "${commit}-${env.BUILD_NUMBER}"
    }

    build job: 'run-end-to-end-direct-debit-tests',
            parameters: [
                    string(name: 'MODULE_NAME', value: app),
                    string(name: 'MODULE_TAG', value: tag),
                    string(name: 'PAY_SCRIPTS_BRANCH', value: pay_scripts_branch)
            ]
}
