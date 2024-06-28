# 29793

Reproduction for https://github.com/renovatebot/renovate/discussions/29793#discussion-6846295.

## Current behavior

Renovate picks up the url for the repository, when defined in `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositories {
        maven("https://maven.pkg.github.com/org/repo/") {
            credentials {
                username = "username"
                password = "password"
            }
        }
    }
}
```

However, the credentials are not used, as the dependency can't be resolved and logs contains lines such as:

```
DEBUG: GET maven.pkg.github.com/org/repo/com/secret/library/confidential/maven-metadata.xml = (code=ERR_NON_2XX_3XX_RESPONSE, statusCode=401 retryCount=0, duration=238) (repository=Org/repo)
DEBUG: Dependency lookup unauthorized. Please add authentication with a hostRule for maven.pkg.github.com/org/repo/com/secret/library/confidential/maven-metadata.xml (repository=Org/repo)
```

It works correctly after adding a host rule with the credentials, but that means duplicating the information:

```json
{
  ...,
  "hostRules": [
    {
      "matchHost": "https://maven.pkg.github.com/org/repo/",
      "hostType": "maven",
      "username": "username",
      "password": "password"
    }
  ]
}
```

## Expected behavior

It would be great if Renovate could also pick up the credentials for the maven repository and generate the host rule, so 
it only needs to be defined in one place.