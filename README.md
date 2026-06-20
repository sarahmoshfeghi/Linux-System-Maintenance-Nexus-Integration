# Linux System Maintenance & Tooling Suite

An Infrastructure as Code pipeline designed to automate Linux operating system patch cycles, kernel updates (with controlled reboots), and the lifecycle management of development infrastructure tools like **Sonatype Nexus OSS**.

## 🛠️ Components Controlled
* **Package Repositories (`tags: [repos]`)**: Refreshes cache arrays, resolves dependencies, and installs safe upgrades.
* **Kernel Upgrades (`tags: [kernel]`)**: Targets latest core kernel engines and issues zero-downtime connection-draining reboots *only* if updates occurred.
* **Sonatype Nexus OSS (`tags: [nexus]`)**: Installs, moves, updates, or deletes Nexus Repository configurations seamlessly.

## 🚀 Execution Guide

### Trigger everything matching configurations:
```bash
ansible-playbook -i inventory.ini site.yml
