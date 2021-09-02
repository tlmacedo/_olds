from django.db import models

class Lead(models.Model):
    id = models.BigAutoField(primary_key=True)
    nome = models.CharField(max_length=120, blank=False, null=False)
    fone = models.CharField(max_length=18, blank=False, null=False)
    email = models.CharField(max_length=254, blank=False, null=False)
    dtcadastro = models.DateTimeField(db_column='dtCadastro', auto_now_add=True)
    dtatualizacao = models.DateTimeField(db_column='dtAtualizacao', null=True,
                                         auto_now=True)

    class Meta:
        db_table = 'lead'

    def __str__(self):
        return self.email
