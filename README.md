### Example

```java
package com.crp;

import com.crp.balance.AllBalance;
import com.crp.response.CrpResponseException;

public class Example
{
    public Example() { }

    public static void main(String[] args) throws CrpResponseException
    {
        Client client = Client.login("your public key",
                "password","");

        System.out.println(" auth");
        System.out.println(client);

        System.out.println(" session");
        System.out.println(client.user_session);

        System.out.println(" user");
        System.out.println(client.getUser());

        System.out.println(" getBalance");
        AllBalance allBalances  = client.getAllBalance();
        allBalances.allbalance.forEach(System.out::println);
    }
}
```
