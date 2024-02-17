const sendPack = (player, key, json) => {
    const api = find("com.daxton.unrealcore.UnrealCore")
    api.sendPack(player, key, json);
}