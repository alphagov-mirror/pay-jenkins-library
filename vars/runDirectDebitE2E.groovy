#!/usr/bin/env groovy

def call(
        String app = null,
        String tag = null,
        String pay_scripts_branch = null) {
    runAppE2E(app, 'directdebit', tag, pay_scripts_branch)
}
