#!/usr/bin/env groovy

def call(
        String app,
        String tag = null,
        testProfile = 'end2end',
        includes = '',
        excludes = '',
        String jobName = 'run-separate-end-to-end-tests') {

    if (tag == null) {
        commit = env.GIT_COMMIT ?: gitCommit()
        tag = "${commit}-${env.BUILD_NUMBER}"
    }

    build job: jobName,
            parameters: [
                    string(name: 'MODULE_NAME', value: app),
                    string(name: 'MODULE_TAG', value: tag),
                    string(name: 'TEST_PROFILE', value: testProfile),
                    stringParam(name: 'INCLUDES', value: includes),
                    stringParam(name: 'EXCLUDES', value: excludes)
            ]
}
