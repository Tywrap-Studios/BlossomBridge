---
tags:
  - Developer Guides
---
# 2.0.0 -> 2.0.1

2.0.1 focused mainly on fixing minor flaws the 2.0.0 update had, updating is suggested, but take note of the problems 2.0.0 serves.

## Patches:
1. Wrongly formatted MC version dependency in `fabric.mod.json`.
2. `ConfigManager.getConfig()` is not null safe, while it used to be before the Kotlin rewrite.  
   (oh the irony)

## Updating
This patch is mostly internal, so no codebase changes are technically needed.  
Do note that you can remove any null checks for your config if you have implemented them.