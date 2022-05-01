package advisor;

import java.util.Arrays;

public class Pagination {

    private static Integer currentPage;
    private static Integer totalPages;
    private static Boolean isAdditionalPageRequired;

    public Pagination() {
    }

    public static Integer getCurrentPage() {
        return currentPage;
    }

    public static Integer getTotalPages() {
        return totalPages;
    }

    /**
     * creates Total pages for pagination
     * assigns and prints first page
     *
     * @param parsables
     */
    public static void printFirstPage(Parsable[] parsables) {
        totalPages = parsables.length / Integer.parseInt(Config.ENTRIES_PER_PAGE);
        if (parsables.length % Integer.parseInt(Config.ENTRIES_PER_PAGE) != 0) {
            totalPages++;
            isAdditionalPageRequired = true;
        } else {
            isAdditionalPageRequired = false;
        }
        currentPage = 1;
        Parsable.printView(Arrays.copyOfRange(parsables, 0, Integer.parseInt(Config.ENTRIES_PER_PAGE)));

    }

    public static void printPageNumberAndTotalPages() {

        System.out.printf("---PAGE %d OF %d---\n", currentPage, totalPages);
    }

    public static void printNextPage(Parsable[] parsables) {

        if (currentPage == totalPages) {
            System.out.println("No more pages."); return;
        }
        currentPage++;
        if (currentPage == totalPages && isAdditionalPageRequired) {
            Parsable.printView(Arrays.copyOfRange(parsables,
                    (currentPage-1)  * Integer.parseInt(Config.ENTRIES_PER_PAGE), parsables.length * 1));
            Pagination.printPageNumberAndTotalPages();

        } else {
            Parsable.printView(Arrays.copyOfRange(parsables, (currentPage - 1) * Integer.parseInt(Config.ENTRIES_PER_PAGE), (currentPage) * Integer.parseInt(Config.ENTRIES_PER_PAGE)));
            Pagination.printPageNumberAndTotalPages();
        }

    }

    public static void printPrevPage(Parsable[] parsables) {
        if (currentPage == 1) {
            System.out.println("No more pages.");
        }
        if (currentPage > 1) {
            Parsable.printView(Arrays.copyOfRange(parsables, (currentPage - 1) * Integer.parseInt(Config.ENTRIES_PER_PAGE) - Integer.parseInt(Config.ENTRIES_PER_PAGE), (currentPage - 1) * Integer.parseInt(Config.ENTRIES_PER_PAGE)));
            currentPage--;
            Pagination.printPageNumberAndTotalPages();
        }

    }
}
