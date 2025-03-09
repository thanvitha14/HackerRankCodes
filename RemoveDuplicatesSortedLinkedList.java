import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RemoveDuplicatesSortedLinkedList {
    public static ListNode removeDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();  // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt();  // Number of elements in the linked list

            if (n == 0) {
                System.out.println();
                continue;
            }

            ListNode head = new ListNode(scanner.nextInt());
            ListNode current = head;

            for (int i = 1; i < n; i++) {
                current.next = new ListNode(scanner.nextInt());
                current = current.next;
            }

            head = removeDuplicates(head);
            printList(head);
        }

        scanner.close();
    }
}
