package com.example.mediguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Interactions_info extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private ImageButton backbtn;
    private String Q1,Q2, Q3,Q4,Q5,Q6,Q7,Q8 , A1,A2,A3,A4,A5,A6,A7,A8;
    String[] questions_array , answer_array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interactions_info);

//        ActionBar actionbar = getSupportActionBar();
//        actionbar.setTitle("Interactions Information");
//        actionbar.setDisplayHomeAsUpEnabled(true);
//        actionbar.setDisplayShowHomeEnabled(true);

        backbtn = findViewById(R.id.back_btn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Interactions_info.this , DashBoard.class));
                finish();
            }
        });

        Q1 = "Drug Interactions?";
        Q2 = "Types of Drugs Interactions?";
        Q3 = "Not to take together?";
        Q4 = "Common Drug Interactions?";
        Q5 = "Take all at once?";
        Q6 = "Symtoms of Drug Interactions?";
        Q7 = "Drug Interactions Happens?";
        Q8 = "Look for Drug Interactions?";

        A1 = "When a medication works right, it boosts your health or helps you feel better.But a drug can bring on \n" +
                "problems if it doesn't mix well with something else you put into your body, like another medication, a \n" +
                "certain food, or alcohol. When that happens, it's called a drug interaction. It could make your \n" +
                "medication stop working, become less effective, or too strong. It could also trigger side effects. The \n" +
                "more you learn about drug interactions, the better you'll be able to avoid them. Here's what you need \n" +
                "to know.";

        A2 = "The main types are:\n" +
                "Drug-drug interaction. This is when a medication reacts with one or more other drugs. For example, \n" +
                "taking a cough medicine (antitussive) and a drug to help you sleep (sedative) could cause the two " +
                "medications to affect each other.\n" +
                "Drug-food/drink interaction. This is when something you eat or drink affects a drug. For instance, it can \n" +
                "be dangerous to drink alcohol while you're on certain medications. Some vitamins and dietary \n" +
                "supplements interact with medicines, too.\n" +
                "Drug-condition interaction. This is when you have a health problem that makes it risky for you to take \n" +
                "certain meds. For example, if you have a condition like high blood pressure, taking a decongestant for a" +
                "cold could drive up your blood pressure even more.\n";

        A3 = "There are many types of drugs you shouldn't take together, but in general, don't take combinations like" +
                "these:\n" +
                "Two or more drugs that share an active ingredient. You could have side effects or an overdose. Active \n" +
                "ingredients are the chemicals in medications that treat your condition or symptoms. Always check for" +
                "them on the drug label.\n" +
                "Blood-thinning drugs with NSAIDs. Your odds for a dangerous bleed could go up. NSAIDs (nonsteroidal \n" +
                "anti-inflammatory drugs) are pain relievers like ibuprofen or naproxen. If you're on a blood thinner, ask \n" +
                "your doctor to suggest a different type of over-the-counter pain medication and dose that's safer for you\n" +
                "Pills with antihistamines. Taking these together can cause you to react more slowly, which would make" +
                "it dangerous for you to drive or work with heavy machines.\n" +
                "Some other drug-drug combinations that can be dangerous are:\n" +
                "An NSAID pain reliever with a blood pressure drug\n" +
                "A thyroid drug called levothyroxine with an acid-blocking proton pump inhibitor drug called omeprazole\n" +
                "An SSRI antidepressant with another medicine that affects serotonin (such as dextromethorphan, \n" +
                "linezolid, tramadol, and trazodone)\n" +
                "A cholesterol-lowering statin with antifungal and fibrate meds that are commonly called \"azole\" drugs \n" +
                "(Their technical names are \"imidazole and triazole derivatives.\" They lower blood fats called \n" +
                "triglycerides.)\n" +
                "The antibiotic clarithromycin with a type of blood pressure drug called a calcium channel blocker";
        A4 = "Certain foods and drinks don't mix well with some medications. A few of these are:\n" +
                "Alcohol. Booze can bring on dangerous side effects with many medications, including some drugs for:\n" +
                "Allergies\n" +
                "Cold and flu\n" +
                "High cholesterol\n" +
                "High blood pressure\n" +
                "Attention deficit hyperactivity disorder (ADHD)\n" +
                "Depression\n" +
                "Diabetes\n" +
                "Infections\n" +
                "Pain\n" +
                "Poor sleep\n" +
                "Before you start a new medication, ask your doctor or pharmacist if it could interact with alcohol. Check \n" +
                "the drug label for alcohol warnings, too.\n" +
                "Grapefruit or grapefruit juice. Too much of either can affect some drugs like:\n" +
                "Statins\n" +
                "Antihistamines\n" +
                "Blood pressure drugs\n" +
                "Anxiety meds\n" +
                "Transplant anti-rejection drugs\n" +
                "Grapefruit juice doesn't mix badly with every type of drug in these classes of medications. Check your \n" +
                "drug's label or information pamphlet for any warnings about it. Also, ask your doctor or pharmacist if it's \n" +
                "safe to have grapefruit or its juice in any amount with your specific drug. If they tell you to stop eating or \n" +
                "drinking it, ask if any other fruits or juices might have similar effects on your medicine.\n" +
                "Foods with vitamin K, like leafy greens. These can interact with the blood thinner warfarin. You don't \n" +
                "have to stop eating them, but it's important to be consistent and not overdo it. Ask your doctor how \n" +
                "much food with vitamin K you can have, then eat the same amount around the same times each week.\n" +
                "High-potassium foods and drinks, like bananas, salt substitutes, and orange juice. These can affect blood" +
                "pressure drugs called ACE inhibitors. Your doctor will track your potassium levels, and they may tell you \n" +
                "to cut back on foods with it.\n" +
                "St. John's wort. This herbal dietary supplement can affect many medications for heart disease, HIV, \n" +
                "depression, and other conditions. It can also affect birth control pills and the cancer drugs irinotecan \n" +
                "and imatinib.\n" +
                "Always get your doctor's or pharmacist's OK before you try a new supplement. It's also possible for a" +
                "medication you take to interact with a health condition you have. Some common drug-condition \n" +
                "interactions happen between:\n" +
                "Antacids and kidney disease\n" +
                "Antihistamines and certain breathing problems, glaucoma, and enlarged prostate\n" +
                "Asthma rescue inhalers and conditions like heart disease, high blood pressure, thyroid disease, and \n" +
                "diabetes.\n" +
                "Decongestants and conditions like heart disease, high blood pressure, thyroid disease, and diabetes\n" +
                "Sleep aids and certain breathing problems, glaucoma, and enlarged prostate.";

        A5 = "It's important to take your medication as directed by your doctor or pharmacist. If two meds interact, \n" +
                "spacing them apart during the day may not stop them from interacting and could lead to new or worse \n" +
                "problems. To avoid an interaction, your doctor may need to change your dose or prescribe a different \n" +
                "medication.\n";
        A6 = "The symptoms of a drug interaction can vary a lot, depending on the drugs you’re taking and how \n" +
                "they’re interacting. Sometimes you might not even know right away that an interaction is happening.\n" +
                "If you do notice an interaction, it will usually feel like one of these is happening:\n" +
                "You are having more side effects from a drug\n" +
                "Your drug doesn’t seem to be working as well as it was before\n" +
                "In general, call your doctor if you're having side effects that worry you or if your medicine doesn't seem \n" +
                "to be working, especially after you’ve recently started or changed doses of a drug.";

        A7 = "There are several ways that drugs can interact with one another. Here are some examples of the most" +
                "common ways.\n" +
                "When two drugs can cause the same side effect and are used at the same time, they might cause more" +
                "of that side effect. For example, if two drugs can each make you sleepy, taking them together can make" +
                "you more or dangerously sleepy.\n" +
                "When the unwanted effects of one drug are the opposite of the desired effects of another drug, you \n" +
                "might end up with less of the desired effects. For example, taking one medication that raises blood \n" +
                "pressure as an unwanted effect may decrease the benefits of taking another medication to lower your" +
                "blood pressure.\n" +
                "Most drugs that you swallow enter your blood through your intestines. Sometimes a drug or \n" +
                "supplement can block or trap another drug in the intestine before it can be absorbed. For example, \n" +
                "supplements like calcium and iron can prevent absorption of thyroid meds.\n" +
                "Your body has enzymes, such as the cytochrome p450 (CYP) and others, that process many types of \n" +
                "medications. This is called metabolism. It also has a way to get rid of drugs, usually though your urine. \n" +
                "Other drugs may speed up, slow down, or even completely block these functions. When this happens, " +
                "the amount of drug in your body may increase (similar to taking too much) or decrease (similar to taking \n" +
                "too little). Either way, this could cause serious problems.\n";

        A8 = "Work closely with your doctor. Make sure they know all the medicines, vitamins, and supplements \n" +
                "you're taking. That's extra important if you have more than one doctor who prescribes medicines for \n" +
                "you. You could show them a list of the meds you're taking, or bring the medication packages to your" +
                "appointment.\n" +
                "Before you take a new drug, ask your doctor or pharmacist questions like:\n" +
                "Can I take this with my other meds?\n" +
                "Should I avoid certain foods, drinks, or other products?\n" +
                "Could this medication interact with any health conditions I have?\n" +
                "Pharmacists are experts on medicine safety, and they can work with your doctors to help you avoid drug \n" +
                "interactions. For example, if you have two doctors and they separately prescribe drugs that interact, \n" +
                "your pharmacist can warn them -- and you -- before you have a problem.\n" +
                "Read labels carefully. Over-the-counter drug labels include information about possible drug interactions \n" +
                "and the medication's active ingredients. Prescription medications usually come with a sheet that \n" +
                "explains what the drug is and how to take it safely.\n" +
                "But most drug labels and patient handouts don't list every possible drug interaction. Talk to your \n" +
                "pharmacist to get the full picture. They can also answer any questions about medical terms or jargon on" +
                "the drug packages.";

        questions_array = new String[]{Q1, Q2 , Q3 , Q4 , Q5 , Q6 , Q7 , Q8};
        answer_array = new String[]{A1 , A2, A3 , A4 , A5 , A6 , A7 , A8};

        ArrayList<String> list = new ArrayList<>();

        list.add("What are Drug Interactions?");
        list.add("What are the 3 types of Drug Interactions?");
        list.add("What Drugs Can you not take together?");
        list.add("What are common Drug Interactions?");
        list.add("Is it OK to Take All your medications at once?");
        list.add("What are the symptoms of a Drug Interaction?");
        list.add("How Do Drug Interactions Happen?");
        list.add("How Do you Look for Drug Interactions?");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        ListView listView = findViewById(R.id.interaction_info_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pop_up(questions_array[i] , answer_array[i]);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Interactions_info.this, DashBoard.class));
    }

//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                startActivity(new Intent(Interactions_info.this , DashBoard.class));
//                finish();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    private void pop_up(String question , String answer)
    {
        final ScrollView scrollView = new ScrollView(this);


        dialogBuilder = new AlertDialog.Builder(this);
        final View info_view = getLayoutInflater().inflate(R.layout.interactions_info_popup , null);
        TextView question_txt = info_view.findViewById(R.id.ques_txt);
        TextView info_txt = info_view.findViewById(R.id.info_txt);
        scrollView.addView(info_view);
        dialogBuilder.setView(scrollView);

        dialog = dialogBuilder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        Button cancel_btn = dialog.findViewById(R.id.cancel_btn);
        question_txt.setText(question);
        info_txt.setText(answer);

        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.dimAmount = 0.75f;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setAttributes(layoutParams);

        assert cancel_btn != null;
        cancel_btn.setOnClickListener(v -> dialog.dismiss());

    }
}
