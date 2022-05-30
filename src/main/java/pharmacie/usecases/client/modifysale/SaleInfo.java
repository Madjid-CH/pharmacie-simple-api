package pharmacie.usecases.client.modifysale;

public record SaleInfo(
        String id,
        String clientId,
        int quantity,
        int price,
        String medicamentName
) {
}
