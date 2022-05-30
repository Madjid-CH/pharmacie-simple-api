package pharmacie.usecases.admin.addmedicament;

public record MedicamentInfo(
        String name,
        int quantity,
        String experationDate,
        int price
) {
}
