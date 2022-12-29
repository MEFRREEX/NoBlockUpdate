# NoBlockUpdate
Prohibits blocks from updating and a few more

```yml
# "protect-all" - protection of all worlds on the server
# "worlds" - worlds in which the protection will operate. Works only if "protect-all" is false

# Prevents blocks from updating
update:
  protect-all: false
  worlds:
    - "world"

# Keeps the leaves from falling out
decay:
  protect-all: false
  worlds:
    - "world"

# Prevents trampling of fields
field:
  protect-all: false
  worlds:
    - "world"
```
