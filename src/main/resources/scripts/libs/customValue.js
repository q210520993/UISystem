const transitionFunctions = (player) => {
    const api = find("com.daxton.unrealcore.application.UnrealCoreAPI").inst(player).getPlaceholderHelper();
    return {
        setValue: (key, startValue, endValue, timeInterval) => {
            api.transitionValueSet(key, startValue, endValue, timeInterval);
        },
        reSet: (key) => {
            api.transitionValueReSet(key);
        },
        remove: (key) => {
            api.transitionValueRemove(key);
        },
        out: (key) => {
            return "{transition_" + key + "}";
        }
    }
}
const customValueFunctions = (player) => {
    const api = find("com.daxton.unrealcore.application.UnrealCoreAPI").inst(player).getPlaceholderHelper();
    return {
        setValue: (key,value) => {
            if (value instanceof find("java.util.HashMap")) {
                api.customValueMultiSet(player,value)
            } else {
                api.customValueSet(player,key,value)
            }
        },
        remove: (key) => {
            api.customValueRemove(player,key)
        },
        removeMuitl: (value) =>{
          api.customValueMultiRemove(player,value)
        },
        clear: ()=>{
            api.customValueClear(player)
        },
        out: (key) => {
            return "{custom_" + key + "}";
        }
    }
}
