String call() {
  if (env.GIT_COMMIT == null) {
    env.GIT_COMMIT = sh(script: "git rev-parse --abbrev-ref HEAD", returnStdout: true).trim()
  }
  env.GIT_COMMIT
}
