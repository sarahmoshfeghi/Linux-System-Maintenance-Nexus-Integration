Safely Update/Patch Package Repositories Only:
```Bash

ansible-playbook -i inventory.ini site.yml --tags repos
```
Trigger Kernel Engine Updates & Necessary Reboots:
```Bash

ansible-playbook -i inventory.ini site.yml --tags kernel
```
Uninstall and Remove Nexus Binaries (Keeps Data Safe):

    In roles/system_maintenance/defaults/main.yml, configure nexus_state: "absent".

    Execute target sequence:

```Bash

ansible-playbook -i inventory.ini site.yml --tags nexus
```
