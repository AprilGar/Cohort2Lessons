## Afternoon Task: Futures

### MVP:

We are continuing from the Eithers MVP task - if yours is incomplete, copy the code from your trainers GitHub and continue from there.

You can either copy your code to a new file and add to it, therefore leaving the Eithers work unchanged or add directly to the Eithers task. If you choose to copy over, you may need to comment out the Eithers code as it might cause errors when running your updated code. 

1. You will need an implicit `ExecutionContext` for this task.
    - Paste `implicit val ec: ExecutionContext = ExecutionContext.global` at the top of the EitherLogic object.
    - **NOTE:** It's not best practice to use this in tests (find out why in your research task).


2. Inside the EitherLogic object, create a method called `.fetchLetter`
    - It takes no parameters.
    - It should return a `Future [Letter]`. 
    - Any letter is fine to return here.
    - Add in a sleep thread of 2 milliseconds. What happens?


3. Inside the EitherLogic object, create a value called `eventualLetter` that calls the `.fetchLetter` method written in MVP Q2.


4. At the bottom of the EitherLogic object, call the `Await.ready` method.
    - This should pass in the `eventualLetter` and `2.seconds` as the time. 
    - If this doesn't find an import for you, use `import scala.concurrent.duration._`.


5. Above the `Await.ready` created in MVP Q4, extract the value from the future using `.value`.
    - Call the `eventualLetter` created this in MVP Q3 and match on it by using: `eventualLetter.value match {`.
    - There should be the following cases:
        - `Some(Success(foundLetter))` => ???
        - `Some(Failure(exception))` => ??? 
        - `None` => ???
    - Instead of ???, add a `println` to each of the above cases which inform us what has happened. Can you use s interpolation? 


6. Run it. What is printed out?


7. Back in the `.fetchLetter` method (from MVP Q2), change/comment out your current sleep thread and add `Thread.sleep(10000000)` above your final return call. Run again, what has changed? Why?

---

### Extension:

1. Create a method called `.fetchLetterOrError`
    - It should take a `(name: String, postCode: String)`.
    - The return type should be `Future [Either [GenericPostageError, Letter]]`.
    - Call the `.letterOrError` method you made earlier in the Letter companion object with this method.
    - Add in a sleep thread of 2 milliseconds. What happens?


2. Create a value called `eventualLetterOrError`.
    - Call the `.fetchLetterOrError` to construct it and make it valid to begin with. 
    - Then try with invalid inputs. 

3. At the bottom of the EitherLogic object, call the `Await.ready` method. This time pass in the `eventualLetterOrError` and `2.seconds` as the time.


4. Similar to before, use the `.value` method and match off the cases for `eventualLetterOrError`, printing out what we have received at each case.

5. Investigate wait times. Change your await from `2.seconds`, what happens? Change the `Thread.sleep` duration in `.fetchLetterOrError`, what happens?

---

### Research:

1. Why is `ExecutionContext.global` not best to use in tests?

2. Try to make a value with type `Either [Future, Letter]`. Why won't this compile?