package com.crp.market;

import com.crp.response.CrpResponse;
import com.crp.Client;
import com.crp.response.CrpResponseException;
import com.crp.response.JsonUtil;
import com.crp.balance.Currency;
import com.crp.market.pair.Pair;
import com.crp.market.pair.Pairs;
import com.crp.market.panel.Panel;
import com.fasterxml.jackson.core.type.TypeReference;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Set;

public class Market
{
    private Client m_Client;

    public Market(Client client)
    {
        m_Client = client;
    }

    public String toString()
    { return "[m_Client = "+ m_Client +"]"; }

    /**  Get trading pairs list */
    public Set<Pairs> getPairs() throws CrpResponseException
    {
        CrpResponse response = new CrpResponse().getResponse(
                "market/pairs", "GET", "auth_token="+ m_Client.auth_token);

        JSONObject obj          = new JSONObject(response.result);

        return JsonUtil.convertJsonToObject(new TypeReference<Set<Pairs>>(){}, obj.getJSONArray("pairs").toString());
    }

    /**  Buy currency
     *   pair   - required
     *   amount - required
     *   price  - required
     */
    public OrderResponse buy(Pair pair, BigDecimal amount, BigDecimal price) throws CrpResponseException
    {
        CrpResponse response = new CrpResponse().getResponse(
                "market/buy?pair="+pair.pair+"&amount="+amount.toString()+"&price="+price.toString(),
                "POST", "auth_token="+ m_Client.auth_token);

        return JsonUtil.convertJsonToObject(new OrderResponse(), response.result);
    }

    /**  Sell currency
     *   pair   - required
     *   amount - required
     *   price  - required
     */
    public OrderResponse sell(Pair pair, BigDecimal amount, BigDecimal price) throws CrpResponseException
    {
        CrpResponse response = new CrpResponse().getResponse(
                "market/sell?pair="+pair.pair+"&amount="+amount.toString()+"&price="+price.toString(),
                "POST", "auth_token="+ m_Client.auth_token);

        return JsonUtil.convertJsonToObject(new OrderResponse(), response.result);
    }

    /**  Hold or Unhold order
     *   orderId - required
     */
    public OrderResponse hold(int orderId) throws CrpResponseException
    {
        CrpResponse response = new CrpResponse().getResponse(
                "market/hold?order_id="+orderId, "POST", "auth_token="+ m_Client.auth_token);

        return JsonUtil.convertJsonToObject(new OrderResponse(), response.result);
    }

    /**  Cancel the specified order
     *   orderId - required
     */
    public OrderResponse cancel(int orderId) throws CrpResponseException
    {
        CrpResponse response = new CrpResponse().getResponse(
                "market/cancel?order_id="+orderId, "POST", "auth_token="+ m_Client.auth_token);

        return JsonUtil.convertJsonToObject(new OrderResponse(), response.result);
    }

    /**  Get order book by trade pair
     *   pair - required
     */
    public Panel getPanel(Pair pair) throws CrpResponseException
    {
        CrpResponse response = new CrpResponse().getResponse(
                "market/panel?pair="+pair.pair, "POST", "auth_token="+ m_Client.auth_token);

        return JsonUtil.convertJsonToObject(new Panel(), response.result);
    }

    /**  Get currencies list */
    public HashMap<String,Currency> getCurList() throws CrpResponseException
    {
        CrpResponse response = new CrpResponse().getResponse(
                "market/curlist", "GET", "auth_token="+ m_Client.auth_token);

        return JsonUtil.convertJsonToObject(new TypeReference<HashMap<String,Currency>>(){}, response.result);
    }
}
