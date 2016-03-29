import java.util.{Date, Calendar}
import scala.util.{Success, Failure, Try}

/**
  * Separate State from Behavior!
  * Handle Exception using Try
  * @return
  */

def today = Calendar.getInstance().getTime
type Amount = BigDecimal

// Define ADT
case class Balance(amount: Amount = 0)

case class Account(no: String, name: String, dateOfOpening: Date,
                   balance: Balance = Balance())

// Define Exception
case class InsufficientAmountException(msg: String) extends Exception(msg)

case class Consumer

// Define Domain service in trait
trait AccountService {

  def openCheckingAccount(consumer: Consumer, effectiveDate: Date) = ???

  def debit(account: Account, amount: Amount): Try[Account] =
    if(account.balance.amount < amount)
      Failure(new InsufficientAmountException("Insufficient balance in account"))
    else
      Success(account.copy(balance = Balance(account.balance.amount - amount)))

  def credit(account: Account, amount: Amount): Try[Account] =
  Success(account.copy(balance = Balance(account.balance.amount + amount)))
}

// plug trait into Singleton object
object AccountService extends AccountService

import AccountService._

val a = Account("001", "Jon", today)

println(a)

val b = credit(a, 900)

println(b)

val test = for {
  c <- credit(a, 50)
  d <- debit(a, 500)
  e <- debit(a, 900)
} yield e

println(test)


