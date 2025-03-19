---
tags:
  - Developer Guides
---
# 2.0.1 -> 2.0.2

2.0.2 again focused mainly on fixing minor flaws the 2.0.0 update had, updating is suggested, but take note of the problems 2.0.0 serves.

## Patches:
1. The Kotlin `BasicConfigClass` isn't serializable by Jankson, so it was replaced with a Java class.

## Updating
This patch is mostly internal, so no codebase changes are technically needed.  
Do note that if your main config didn't work due to the Kotlin class, you might need to re-implement it with the new Java class.