--------------
# Daily-Smarts
Android Module Final Project - Android App

Collaborators: Nancy Ilieva and Hristo Tsekov
E-Mails: gnr.axlrose.6.2.1962@gmail.com, xtsekooov@gmail.com


-------------------------------
1. ЗА ПРОЕКТА И РЕАЛИЗАЦИЯТА МУ
Проектът представлява мобилно приложение за Андроид, написано на програмния език Java.
За да стартирате и тествате приложението ни, трябва да имате изтеглено Android Studio на компютъра си със сетъпната конфигурация. 
Оттук може да изтеглите средата: https://android-studio.en.uptodown.com/windows

----------------------
2. УСЛОВИЕ НА ЗАДАЧАТА
Daily Smarts application
Създайте приложение за цитати, което да показва случаен цитат при всяко стартиране и позволява запазване на любими цитати.
Използвайте http://forismatic.com/en/api/ за да го реализирате.
*************************************************************************************************************************
Описание на функционалностите 
*************************************************************************************************************************
Аппът има туулбар с името на апп-а: Daily Smarts 
Аппът има два функциониращи таба: Daily Quote и My Quotes 
Daily Quote табът има една карта, показваща цитат, автор и два бутона, според посочен дизайна 
My Quotes табът има списък с карти, показващи цитат, автор и два бутона, според дизайна 
Аппът се свързва с онлайн базата с цитати и взима един случаен цитат 
Аппът показва взетия цитат на Daily Quote екрана 
Аппът има локална база данни 
При натискане на празното сърчице на Daily Quote таба, цитатът се запазва в локалната база данни, сърчицето се запълва 
Повторно натискане на сърчицето на Daily Quote таба изтрива цитатът от базата 
My Quotes таба зарежда запазените в локалната база цитати 
При натискане на сърчицето на My Quotes таба, цитатът се изтрива от локалната база данни 
Когато потребителят е на Daily Quote таба, в туулбара има екшън бутон Refresh. При натискането му, цитатът на екрана се сменя с друг от онлайн базата 
Всички карти имат Share бутон, който при натискане споделя въпросният цитат през един от другите апповете на юзъра (позволявайки юзъра да избере кой точно)
При добавяне/изтриване на цитати от базата данни, списъкът с цитати на My Quotes таба се обновява автоматично и показва актуалните данни в базата 
Дизайнът на аппа (компоненти, цветове, шрифтове и отстояния) отговаря на дизайна, допълнително посочен 

*************************************************************************************************************************
Бонус функционалности 
*************************************************************************************************************************
Цитатът да бъде обвързан с деня - ако отвориш два пъти аппа в един и същ ден, цитатът да бъде един и същ, освен ако потребителя не натисне рефреш бутона.
Потребителя да може да избира езика на цитатите - английски или руски 
при зареждане и рефрешване на данните да се появява индикатор за това 
при липса на интернет да се уведомява потребителя
при дърпане на екрана надолу, да се рефрешват данните (т.нар. Swipe to Refresh) 

*************************************************************************************************************************
Качество на кода 
*************************************************************************************************************************
Правилно и логично именовани променливи, методи и класове
Малки и компактни методи, без странични действия
Малки класове
Логично разделен код по пакети

*************************************************************************************************************************
Описание на компонентите
*************************************************************************************************************************
Част от компонентите, които трябва да присъстват в аппа ви са:
Activity
Fragment
RecyclerView
Връзка с интернет и парсване на данни от там
Локална база

------------------------------------
3. СТРУКТУРИ И ИЗПОЛЗВАНИ ТЕХНОЛОГИИ
Приложението се определя като мобилно и спазва съответните конвекции за качество на код. 
Паралелно с реализирането на функционалностите, опитахме да спазим добрите практики за clean code.
Приложението съдържа DrawerMenu
Приложението използва Dependency Injection (setUp-нат dagger)
Използвана е MVP (Model-View-Presenter) архитектура. 
Приложението е свързано с локална база данни и API.
Съответно според нуждите на гореизброените архитектури/технологии файловете са разделени по класове, които от своя страна са подредени в пакети.

------------------------------------
4. КРАТКО РЪКОВОДСТВО НА ПОТРЕБИТЕЛЯ
Инсталирайте приложението. При стартирането му ще видите най-отгоре туулбар с името на аппа, а също и два бутона - за смяна на езика и за рефрешване на данните. 
Отдолу ще имате опция да изберете между два таба (две основни смислови подразделение на приложението) - Daily Quote и My Quotes. 
Какво ще видите в Daily Quote Tab-а: една карта, която извежда на случаен принцип от свързана база данни от интернет един цитат, а отдолу и неговия автор. 
В картата ще видите и два бутона - сърчице и икона за споделяне. 
При натискане на сърчицето, то се запълва в червено и цитатът се запазва в локалната база данни. 
При повторно натискане на сърчицето, то отново става празно, а цитатът е изтрит от базата данни. 
При натискане на иконата за споделяне на потребителя се дава избор измежду други приложения, чрез които да сподели цитата.
Първоначално при стартиране на апликацията, цитатите излизат на английски. След това при натискане на иконката eng/rus езикът се сменя на руски. 
Ако я натиснете, докато виждате дневния цитат на руски, то ще се генерира нов на английски. Цитатите се запзват в базата данни на съответния език. 
Бутонът за рефреш презарежда страницата (т.е. появява се нов daily quote, който е индикатор за успешното рефрешване на данните)
Какво ще видите в My Quotes Tab-a: карти със запазените цитати, техните автори и два бутона на всяка карта - за споделяне и сърчицето, което когато се натисне в този случай, 
изтрива цитатът от базата данни.
Когато затворите аппа, а след това пак го отворите ще се покаже последния daily quote(на английски, т.к. приложението при зареждането си извежда английски интерфейс, 
а при смяна на езика - на руски).
Цитатът е обързан с деня - когато отворите приложението два пъти в един ден, без да се рефрешва дейли куота, приложението отваря същия цитат. 
Ако сте рефрешнали - то ще показва новия цитат.
За да използвате приложението, трябва да имате достъп до интернет.

-----------------------------
5. ОПИСАНИЕ НА ПРОГРАМНИЯ КОД
DailyQuoteFragment- един от двата основни таба, в който се съдържа карта със случайно генериращ се всеки ден цитат, който, от своя страна, е обвързан с деня
boolean ifQuoteIsAlreadySaved - тази променлива съдържа булева информация дали дневният цитат е запазен в базата данни
getAndSetNewQuote()- генерира нов цитат на руски или английски в зависмост от конкретните нужди на аппа и задава вютата
getAndSetNewRusQuote() и getAndSetNewEngQuote()- генерира нов цитат на руски или английски, изпълняват се в горния метод
changeLang()- сменя езика на дневния цитат
deleteQuoteByQuoteText()- изтрива цитат според текста му
shareQuote()- споделя цитат, като позволява на юзъра да избира приложение, чрез което да сподели информацията
MyQuotesFragment- показва чрез recyclerView локалната база данни със запазените от потребителя цитати
tabManager()- контролира преминаването между фрагментите
refreshData()- слага се в swipeForRefreshLayout -> генерира нов daily quote
isNetworkAvailable()- проверява дали има връзка с интернета или е в процес на свързване към интернет при стартиране на апликацията
sharedPreference - локална база данни, в която се съхраняват двата дневни цитата (на руски и английски) и датата на последното логване

-----------------------
6. ИЗПОЛЗВАНИ ИЗТОЧНИЦИ 
https://stackoverflow.com
https://developer.android.com
https://www.geeksforgeeks.org
https://developer.android.com
конултации с Тео и Краси 
YouTube Tutorials на индийци 
