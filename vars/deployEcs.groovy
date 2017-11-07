#!/usr/bin/env groovy

def call(String microservice, String aws_profile, String tag = null, boolean tagAfterDeployment = false, boolean run_tests = true) {
    tag = tag ?: gitCommit()
    
    build job: 'deploy-ecs-microservice',
        parameters:[
          string(name: 'MICROSERVICE', value: microservice),
          string(name: 'MICROSERVICE_IMAGE_TAG', value: tag),
          string(name: 'AWS_PROFILE', value: aws_profile),
          booleanParam(name: 'TAG_AFTER_DEPLOYMENT', value: tagAfterDeployment),
          booleanParam(name: 'RUN_TESTS', value: run_tests)
        ]
}
