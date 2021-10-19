# rekt-nodes
Lookup service for REKT Lightning Network Nodes

- [Installation](#how-to-install)
- [Node Recovery Scenarios](#node-recovery-scenarios)

Your Lightning Network node is REKT and you just realized you don't have a static channel backup? Don't panic! This service might be your chance to get those funds back. 

Register your node to either ask your channel partners to close a channel or receive notifications from peers that need your help. All you need to do is to verify you are in control of the node with your signature that is derived from your seed (and passphrase, if you have one). 

If you still have your static channel backup, the [Channel Tools](https://github.com/guggero/chantools#readme) may help you recover your node. If you lost your seed too, only Harry Potter may help you in this case unfortunately. 

## how to install


## Channel recovery scenarios

Your node just crashed. There are different scenarios how to recover it depending on how you backed up your DB. 

* Scenario 1: You have a backup of your channels  
The first thing to check is if a simple [compaction](https://github.com/guggero/chantools/blob/master/doc/chantools_compactdb.md) can solve your problem. A compaction is a full copy of your DB in safe mode. If not, [this guide](https://github.com/lightningnetwork/lnd/blob/master/docs/safety.md#static-channel-backups-scbs) helps you to recover your node from your static channel backup. 

* Scenario 2a: You don't have a channel backup, your channel peers are online  
If you haven't backuped your channels but you are still in control of your seed (and passphrase if you defined one), use our service to check on your alive channel partners and notify them of your problem. They will then force-close the channel and you can access your funds on-chain with your seed. 

* Scenario 2b: You don't have a channel backup, your channel peers are offline  
If you haven't backuped your channels but you are still in control of your seed (and passphrase), use our service to find out if your channel peers are offline, too. The [chantools forceclose](https://github.com/guggero/chantools/blob/master/README.md#channel-recovery-scenario) helps you with this case. You will have to wait until the time-lock of your HTLC has ended to recover your funds.
