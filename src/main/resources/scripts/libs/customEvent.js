const customEvent = (key) =>{
    const api = find("com.skillw.uisystem.api.event.CustomEvent")
    return new api(key)
}