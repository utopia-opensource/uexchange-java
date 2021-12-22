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
        Client client = Client.login("52EAECEA83437ADDA5800E2C9EEB6D456753B0B2CD11D37B90DFABA1592ED955",
                "qwerty12345","");

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
