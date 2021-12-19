package com.crp;
import com.crp.response.CrpResponse;
import com.crp.balance.AllBalance;
import com.crp.balance.Currency;
import com.crp.history.HistoryItem;
import com.crp.history.HistoryTrade;
import com.crp.market.Market;
import com.crp.market.OrderResponse;
import com.crp.market.pair.Pair;
import com.crp.market.pair.Pairs;
import com.crp.market.panel.Panel;
import com.crp.orders.OrderHistory;
import com.crp.orders.Orders;
import com.crp.response.CrpResponseException;
import com.crp.response.JsonUtil;
import com.crp.user.User;
import com.crp.user.UserSession;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class Client
{
    public  User        getUser()       { return user_session.user; }
    public  UserSession user_session;
    public  String      auth_token;

    public Client() {}

    @JsonCreator public Client(
    @JsonProperty("user_session") UserSession    user_session,
    @JsonProperty("auth_token")   String         auth_token)
    {
        this.user_session = user_session;
        this.auth_token   = auth_token;
        m_Market          = new Market(this);
    }

    /**  Sign in to system
     *   publicKey   - required
     *   password    - required
     *   twoFa_pin   - optional
     */
    public static Client login(String publicKey, String password, String twoFa_pin) throws CrpResponseException
    {
        CrpResponse response = new CrpResponse().getResponse(
                "user/login?PublicKey="+publicKey+"&password="+password+"&2fa_pin="+twoFa_pin, "POST", "");

        return JsonUtil.convertJsonToObject(new Client(), response.result);
    }

    /**  Sign out from system */
    public void logout() throws CrpResponseException
    {
        CrpResponse response = new CrpResponse().getResponse(
                "user/logout", "POST", "auth_token="+auth_token);

        System.out.println(response.result);
    }

    public String toString()
    { return "[userSession = "+user_session+", authToken = "+auth_token+"]"; }


    /**  BALANCE START ************************************************************************************************/
    /***/

    /**  Get all user balances */
    public AllBalance getAllBalance() throws CrpResponseException
    {
        CrpResponse response = new CrpResponse().getResponse(
                "user/balance", "GET", "auth_token="+auth_token);

        return JsonUtil.convertJsonToObject(new AllBalance(), response.result);
    }
    /**  BALANCE END **************************************************************************************************/



    /**  MARKET START *************************************************************************************************/
    /***/

    @JsonIgnore
    private Market      m_Market;
    public  Market      getMarket()                          { return m_Market; }

    /**  Get trading pairs list */
    public Set<Pairs> getPairs() throws CrpResponseException
    { return getMarket().getPairs(); }

    /**  Get order book by trade pair
     *   pair - required
     */
    public Panel getPanel(Pair pair) throws CrpResponseException
    { return getMarket().getPanel(pair); }

    /**  Get currencies list */
    public HashMap<String, Currency> getCurList() throws CrpResponseException
    { return getMarket().getCurList(); }

    /**  Buy currency
     *   pair   - required
     *   amount - required
     *   price  - required
     */
    public OrderResponse buy(Pair pair, BigDecimal amount, BigDecimal price) throws CrpResponseException
    { return getMarket().buy(pair, amount, price); }

    /**  Sell currency
     *   pair   - required
     *   amount - required
     *   price  - required
     */
    public OrderResponse sell(Pair pair, BigDecimal amount, BigDecimal price) throws CrpResponseException
    { return getMarket().sell(pair, amount, price); }

    /**  Hold or Unhold order
     *   orderId - required
     */
    public OrderResponse hold(int orderId) throws CrpResponseException
    { return getMarket().hold(orderId); }

    /**  Cancel the specified order
     *   orderId - required
     */
    public OrderResponse cancel(int orderId) throws CrpResponseException
    { return getMarket().cancel(orderId); }
    /**  MARKET END ***************************************************************************************************/



    /**  ORDERS START *************************************************************************************************/
    /***/

    /**  Get orders list
     *   status   - optional Values: open/close/cancel/hold
     *   task     - optional Values: buy/sell
     */
    public enum OrderStatus { open, close, cancel, hold; }
    public enum OrderTask   { buy, sell; }

    public Orders getOrders(OrderStatus status, OrderTask task) throws CrpResponseException
    {
        CrpResponse response = new CrpResponse().getResponse(
                "orders?status="+status.name()+"&task="+task.name(), "GET", "auth_token="+auth_token);
        return JsonUtil.convertJsonToObject(new Orders(), response.result);
    }

    public Orders getOrders(OrderStatus status) throws CrpResponseException
    {
        CrpResponse response = new CrpResponse().getResponse(
                "orders?status="+status.name(), "GET", "auth_token="+auth_token);

        return JsonUtil.convertJsonToObject(new Orders(), response.result);
    }

    public Orders getOrders(OrderTask task) throws CrpResponseException
    {
        CrpResponse response = new CrpResponse().getResponse(
                "orders?task="+task.name()+"", "GET", "auth_token="+auth_token);
        return JsonUtil.convertJsonToObject(new Orders(), response.result);
    }

    public Orders getOrders() throws CrpResponseException
    {
        CrpResponse response = new CrpResponse().getResponse(
                "orders", "GET", "auth_token="+auth_token);
        return JsonUtil.convertJsonToObject(new Orders(), response.result);
    }

    /**  Get orders history
     *   orderId  - required
     */
    public OrderHistory getOrdersHistory(int orderId) throws CrpResponseException
    {
        CrpResponse response = new CrpResponse().getResponse(
                "orders/history?order_id="+orderId, "POST", "auth_token="+auth_token);
        return JsonUtil.convertJsonToObject(new OrderHistory(), response.result);
    }
    /**  ORDERS END ***************************************************************************************************/



    /**  HISTORY START ************************************************************************************************/
    /***/

    /**  Get trading history by pairs
     *   pair     - required
     */
    public HistoryTrade getHistoryTrade(Pair pair) throws CrpResponseException
    {
        CrpResponse response = new CrpResponse().getResponse(
                "history/trade?pair="+pair.pair, "GET", "auth_token="+auth_token);
        return JsonUtil.convertJsonToObject(new HistoryTrade(), response.result);
    }

    /**  Get operations history
     *   type           - required      Values: profile/trade/billing
     *   from_id        - optional      (uuid)	Pagination offset
     *   record_type    - optional      Billing operation type (only for billing)	payment/comission/withdraw or combined
     *   currency       - optional      Currency (only for billing type)
     */
    public enum HistoryType         { profile, trade, billing; }
    public enum BillingOperation    { payment, comission, withdraw, combined; }
    public LinkedList<HistoryItem> getHistory(HistoryType type, String fromId, BillingOperation recordType, Currency currency) throws CrpResponseException
    {
        CrpResponse response = new CrpResponse().getResponse(
                "history?type="+type.name()+"&from_id="+fromId+"&record_type="+recordType.name()+"&currency="+currency.name
                , "POST", "auth_token="+auth_token);
        JSONObject obj          = new JSONObject(response.result);
        return JsonUtil.convertJsonToObject(new TypeReference<LinkedList<HistoryItem>>(){}, obj.getJSONArray("items").toString());
    }

    public LinkedList<HistoryItem> getHistory(HistoryType type, String fromId) throws CrpResponseException
    {
        CrpResponse response = new CrpResponse().getResponse(
                "history?type="+type.name()+"&from_id="+fromId, "POST", "auth_token="+auth_token);
        JSONObject obj          = new JSONObject(response.result);
        return JsonUtil.convertJsonToObject(new TypeReference<LinkedList<HistoryItem>>(){}, obj.getJSONArray("items").toString());
    }

    public LinkedList<HistoryItem> getHistory(HistoryType type) throws CrpResponseException
    {
        CrpResponse response = new CrpResponse().getResponse(
                "history?type="+type.name(), "POST", "auth_token="+auth_token);
        JSONObject obj          = new JSONObject(response.result);
        return JsonUtil.convertJsonToObject(new TypeReference<LinkedList<HistoryItem>>(){}, obj.getJSONArray("items").toString());
    }
    /**  HISTORY END **************************************************************************************************/
}
