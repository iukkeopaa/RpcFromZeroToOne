package org.wqz.convergencerpc.Version3.Server;



import java.util.HashMap;
import java.util.Map;


public class ServiceProvider {

    private Map<String, Object> interfaceProvider;

    public ServiceProvider(){
        this.interfaceProvider = new HashMap<>();
    }

    public void provideServiceInterface(Object service){
        Class<?>[] interfaces = service.getClass().getInterfaces();

        for(Class clazz : interfaces){
            interfaceProvider.put(clazz.getName(),service);
        }

    }
    public Object getService(String interfaceName){
        return interfaceProvider.get(interfaceName);
    }
}
