package com.mytestpractice;

import java.util.concurrent.*;
//import java.util.*;

public class DemoCompletableFuture {

    public static void main(String[] args) throws Exception {

        // 1. supplyAsync
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");

        // 2. runAsync
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() ->
            System.out.println("Running task asynchronously")
        );

        // 3. thenApply
        CompletableFuture<String> future3 = future1.thenApply(s -> s + " World");

        // 4. thenAccept
        future3.thenAccept(result ->
            System.out.println("thenAccept: " + result)
        );

        // 5. thenRun
        future3.thenRun(() ->
            System.out.println("thenRun: Task completed!")
        );

        // 6. thenCombine
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "Java");
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "Rocks");
        CompletableFuture<String> combined = f1.thenCombine(f2, (a, b) -> a + " " + b);
        System.out.println("thenCombine: " + combined.get());

        // 7. thenCompose
        CompletableFuture<String> composed = future1.thenCompose(msg ->
            CompletableFuture.supplyAsync(() -> msg + " CompletableFuture")
        );
        System.out.println("thenCompose: " + composed.get());

        // 8. allOf
        CompletableFuture<Void> all = CompletableFuture.allOf(
            CompletableFuture.runAsync(() -> System.out.println("Task 1")),
            CompletableFuture.runAsync(() -> System.out.println("Task 2"))
        );
        all.get(); // Wait for all to complete

        // 9. anyOf
        CompletableFuture<Object> any = CompletableFuture.anyOf(
            CompletableFuture.supplyAsync(() -> "Result 1"),
            CompletableFuture.supplyAsync(() -> "Result 2")
        );
        System.out.println("anyOf: " + any.get());

        // 10. exceptionally
        CompletableFuture<Object> exFuture = CompletableFuture
            .supplyAsync(() -> { throw new RuntimeException("Oops!"); })
            .exceptionally(ex -> "Recovered from error");
        System.out.println("exceptionally: " + exFuture.get());

        // 11. handle
        CompletableFuture<Object> handled = CompletableFuture
            .supplyAsync(() -> { throw new RuntimeException("Failure"); })
            .handle((res, ex) -> ex != null ? "Handled Error" : res);
        System.out.println("handle: " + handled.get());

        // 12. whenComplete
        CompletableFuture<String> completeFuture = CompletableFuture
            .supplyAsync(() -> "Completed Successfully")
            .whenComplete((result, ex) -> {
                if (ex == null) System.out.println("whenComplete: " + result);
            });
        completeFuture.get();

        // 13. complete
        CompletableFuture<String> manualFuture = new CompletableFuture<>();
        manualFuture.complete("Manual Completion");
        System.out.println("complete: " + manualFuture.get());

        // 14. completeExceptionally
        CompletableFuture<String> failedFuture = new CompletableFuture<>();
        failedFuture.completeExceptionally(new RuntimeException("Manual failure"));

        try {
            System.out.println("completeExceptionally: " + failedFuture.get());
        } catch (Exception e) {
            System.out.println("completeExceptionally caught: " + e.getMessage());
        }

        // 15. join
        String joinedResult = CompletableFuture.supplyAsync(() -> "Join Example").join();
        System.out.println("join: " + joinedResult);
    }
}
